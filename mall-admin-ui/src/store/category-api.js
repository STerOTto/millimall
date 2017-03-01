import axios from 'axios'

axios.defaults.headers.common['Authorization'] = 'Basic bWFsbC1zYW1wbGUtY2xpZW50OjEyMzQ1Ng=='
let adminURL = 'http://localhost:9898'

export const getAccessToken = (params) => {
  return axios.post(`${adminURL}/sso/oauth/token`, {params: params})
}

export const createCategory = (params) => {
  return axios.post(`${adminURL}/goods/category`, {params: params})
}

export const getCategoryList = (params) => {
  return axios.get(`${adminURL}/goods/category`, {params: params})
}
