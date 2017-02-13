import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)
import Login from './components/Login'
import Hello from './components/Hello'

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/login',
      component: Login,
      name: '',
      hidden: true
    },
    {
      path: '/hello',
      component: Hello,
      name: '',
      hidden: true
    }
  ]
})
