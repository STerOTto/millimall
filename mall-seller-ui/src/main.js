// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import Vuex from 'vuex'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-default/index.css'
import router from './routes'

Vue.use(ElementUI)
Vue.use(Vuex)

router.beforeEach((to, from, next) => {
  let isAuthenticated = JSON.parse(window.sessionStorage.getItem('isAuthenticated') || 'false')
  if (isAuthenticated === true || to.path === '/login') {
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
}).$mount('#app')
