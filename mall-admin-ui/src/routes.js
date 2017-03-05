import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)
import Login from './components/Login'
import Index from './components/Index'
import Category from './components/category/Category'

const router = new Router({
  mode: 'history',
  routes: [
    {
      path: '/login',
      component: Login,
      name: '',
      hidden: true
    },
    {
      path: '/',
      component: Index,
      name: '',
      hidden: true,
      children: [
        {
          path: '/category',
          component: Category,
          name: '后台类目',
          hidden: true
        }
      ]
    }
  ]
})

export default router
