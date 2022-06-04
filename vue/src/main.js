import Vue from 'vue'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import './assets/global.css'
import request from "./utils/request";
import store from './store'
import moment from "moment";
import zhCN from "element-ui/src/locale/lang/zh-CN";
Vue.config.productionTip = false

Vue.use(ElementUI,{size:"mini"});

Vue.prototype.request=request

Vue.prototype.$moment = moment
moment.locale("zh-cn")

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
