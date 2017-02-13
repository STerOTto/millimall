// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import Vuex from 'vuex'
import VueRouter from 'vue-router'
import ElementUI from 'element-ui'
import routes from './routes'

Vue.use(ElementUI)
Vue.use(VueRouter)
Vue.use(Vuex)

const router = new VueRouter({routes})
router.beforeEach((to, from, next) => {
  let isAuthenticated = JSON.parse(window.sessionStorage.getItem('isAuthenticated') || 'false')
  if (isAuthenticated === true) {
    next()
  } else {
    next({ path: '/login' })
  }
})

/* eslint-disable no-new */
new Vue({
  el: '#app',
  template: '<App/>',
  router,
  components: { App }
})
