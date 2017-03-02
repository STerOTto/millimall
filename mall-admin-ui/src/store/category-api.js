import axios from 'axios'

let adminURL = 'http://localhost:9898'

export const getAccessToken = (params) => {
  let instance = axios.create({
    baseURL: `http://localhost:9999/sso`,
    timeout: 1000
  })
  instance.defaults.headers.post['Authorization'] = 'Basic bWFsbC1zYW1wbGUtY2xpZW50OjEyMzQ1Ng=='
  instance.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded'
  return instance.post('/oauth/token', params)
}

export const createCategory = (params) => {
  axios.defaults.headers.post['Content-Type'] = 'application/json;charset=UTF-8'
  axios.defaults.headers.post['Authorization'] = 'Bearer ' + window.sessionStorage.getItem('access_token')
  return axios.post(`${adminURL}/goods/categories`, JSON.stringify(params))
}

export const getCategoryList = (params) => {
  return axios.get(`${adminURL}/goods/categories`, params)
}
