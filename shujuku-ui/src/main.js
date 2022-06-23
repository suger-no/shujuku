import Vue from 'vue'
import App from './App.vue'
import router from './router'
import Element from 'element-ui'
import "element-ui/lib/theme-chalk/index.css"
import axios from 'axios'
import store from "@/store";
Vue.config.productionTip = false
// axios.defaults.withCredentials = true;

Vue.prototype.$axios = axios.create({
  baseURL:'http://127.0.0.1:8082'
})

Vue.use(Element)
new Vue({
  render: h => h(App),
  router,
  store
}).$mount('#app')
