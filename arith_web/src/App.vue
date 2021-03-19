<template>
  <div id="app">
    <audio
      controls
      style="display: none"
      :src="mp3_url"
      type="audio/mpeg"
      id="audio-player"
      ref="player"
    >
      Your browser does not support the audio tag.
    </audio>

    <h3>
      <button @click.stop="operate(1)"><u>A</u>dd</button>
    </h3>
    <h3>
      <button @click.stop="operate(2)"><u>S</u>ub</button>
    </h3>
    <h3>
      <button @click.stop="operate(3)"><u>M</u>ul</button>
    </h3>
    <h3>
      <button @click.stop="operate(4)"><u>D</u>iv</button>
    </h3>
    <h1 v-show="true">{{ description }}</h1>
    <h2 v-show="show_answer">{{ answer }}</h2>
    <h3>练习简单的加减乘除</h3>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "App",
  data() {
    return {
      filename: "error",
      answer: "",
      description: "",
      mp3_url: "/mp3/error.mp3",
      show_answer: false
    };
  },
  methods: {
    play() {
      let audio = this.$refs.player;
      audio.play();
    },
    operate(op) {
      // console.log(process.env.BASE_URL);
      this.show_answer = false;
      axios
        .get("/ask/" + op) // http://localhost:8888/
        .then(response => {
          let json = response.data;
          this.filename = json.name;
          this.mp3_url = "/mp3/" + this.filename + ".mp3";
          this.answer = json.answer;
          this.description = json.description;
        })
        .catch(function(error) {
          console.log(error);
        })
        .then(() => {
          this.play();
        });

      setTimeout(() => {
        this.show_answer = true;
      }, 1000);
    }
  },
  mounted() {
    let that = this;
    window.addEventListener("keyup", function(event) {
      switch (event.code) {
        case "KeyA":
          that.operate(1);
          break;
        case "KeyS":
          that.operate(2);
          break;
        case "KeyM":
          that.operate(3);
          break;
        case "KeyD":
          that.operate(4);
          break;
        case "Enter":
          break;
        case "Space":
          that.play();
          break;
        default:
          break;
      }
    });
  }
};
</script>

<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
button {
  font-size: 2rem;
  font-family: Consolas, Monaco, Lucida Console, Liberation Mono,
    DejaVu Sans Mono, Bitstream Vera Sans Mono, Courier New, monospace;
}
</style>
