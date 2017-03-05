import axios from 'axios'
import store from '../store'
import * as types from '../store/mutation-types'
import router from '../routes'

// axios 配置
axios.defaults.timeout = 5000
axios.defaults.baseURL = 'http://localhost:9898'
axios.defaults.headers.common['Content-Type'] = 'application/json'

// http request 拦截器
axios.interceptors.request.use(
  config => {
    console.log('request - interceptors', store.state.auth.authInfo.access_token)
    if (store.state.auth.authInfo) {
      config.headers.Authorization = `Bearer ${store.state.auth.authInfo.access_token}`
    }
    return config
  },
  err => {
    return Promise.reject(err)
  })

// http response 拦截器
axios.interceptors.response.use(
  response => {
    console.log('response - interceptors')
    return response
  },
  error => {
    if (error.response) {
      console.log('http error', store, router, types)
      switch (error.response.status) {
        case 401:
          // 401 清除token信息并跳转到登录页面
          store.commit(types.LOGOUT)
          router.replace({
            path: 'login',
            query: {redirect: router.currentRoute.fullPath}
          })
          break
        default:
          return Promise.reject(error.response.data)
      }
    }
    return Promise.reject(error)
  })
export default axios
