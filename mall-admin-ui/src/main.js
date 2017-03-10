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
import * as types from './store/mutation-types'

Vue.use(ElementUI)
Vue.prototype.axios = axios
Vue.component('admin-breadcrumb', Breadcrumb)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  template: '<App/>',
  axios,
  router,
  store,
  components: { App }
}).$mount('#app')

let authInfo = window.sessionStorage.getItem('MALL_ADMIN_AUTH')
if (authInfo) {
  authInfo = JSON.parse(authInfo)
  console.log('refresh commit authInfo', authInfo)
  store.commit(types.LOGIN, {authInfo})
  console.log('after commit authInfo', store.state.auth.authInfo)
}

router.beforeEach((to, from, next) => {
  // if (to.matched.some(r => r.meta.requireAuth)) {
  //
  // } else {
  //   next();
  // }
  console.log(store.state.auth.authInfo)
  if (to.path === '/login' || store.state.auth.authInfo.access_token) {
    next()
  } else {
    console.log('require login', store.state.auth.authInfo)
    next({
      path: '/login',
      query: {redirect: to.fullPath}
    })
  }
})
