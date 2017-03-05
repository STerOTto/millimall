// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import store from './store'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-default/index.css'
import router from './routes'
import axios from './api/http'
import Breadcrumb from './components/Breadcrumb'

Vue.use(ElementUI)
Vue.prototype.axios = axios
Vue.component('admin-breadcrumb', Breadcrumb)
import * as types from './store/mutation-types'

/* eslint-disable no-new */
new Vue({
  el: '#app',
  template: '<App/>',
  axios,
  router,
  store,
  components: { App }
}).$mount('#app')

// TODO 页面刷新时，重新赋值token, doesn't work yet
let authInfo = window.sessionStorage.getItem('MALL_ADMIN_AUTH')
if (authInfo) {
  authInfo = JSON.parse(authInfo)
  console.log('refresh', authInfo)
  store.commit(types.LOGIN, authInfo)
}
