import axios from '../api/http'

let adminURL = 'http://localhost:9898'

export const createCategory = (params) => {
  return axios.post(`${adminURL}/goods/categories`, params)
}

export const getCategoryList = (params) => {
  return axios.get(`${adminURL}/goods/categories`, params)
}
