import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)
import Login from './components/Login'
import Index from './components/Index'
import Category from './components/category/Category'
import CategoryAttributeTemplate from './components/category/CategoryAttributeTemplate'
import CreateGoods from './components/goods/CreateGoods'

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
      name: '首页',
      hidden: true,
      children: [
        {
          path: '/category',
          component: Category,
          name: '后台类目',
          hidden: true
        },
        {
          path: '/category-attribute-template',
          component: CategoryAttributeTemplate,
          name: '类目属性模板',
          hidden: true
        },
        {
          path: '/create-goods',
          component: CreateGoods,
          name: '发布商品',
          hidden: true
        }
      ]
    }
  ]
})

export default router
