import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)
import Login from './components/Login'
import Index from './components/Index'

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
      path: '/index',
      component: Index,
      name: '',
      hidden: true
    }
  ]
})
