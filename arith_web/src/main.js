import Vue from "vue";
import App from "./App.vue";
//import VueAxios from "vue-axios";

Vue.config.productionTip = false;
//Vue.use(VueAxios, axios);

new Vue({
  render: h => h(App)
}).$mount("#app");
