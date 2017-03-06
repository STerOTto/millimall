import Vue from 'vue'
import * as types from '../mutation-types'
import { createCategory, getCategoryList } from '../../api/category-api'

const state = {
  categoryList: []
}

const getters = {
  allCategories: state => state.categoryList
}

const actions = {
  addCategory: ({ commit }, category) => {
    commit(types.ADD_CATEGORY, {category})
  },
  getCategoryList: ({ commit }) => {
    getCategoryList().then(res => {
      let categoryList = res.data
      commit(types.RECEIVE_CATEGORY_LIST, { categoryList })
    })
  }
}

const mutations = {
  [types.RECEIVE_CATEGORY_LIST]: (state, { categoryList }) => {
    state.categoryList = categoryList
  },
  [types.ADD_CATEGORY]: (state, { category }) => {
    let asRoot = category.parentId === -1
    let parentCate = state.categoryList.find(cate => { return (cate.id === category.parentId) })

    if (asRoot || parentCate) {
      createCategory(category).then((res) => {
        if (asRoot) {
          state.categoryList.push(category)
        } else {
          if (!parentCate.children) {
            Vue.set(parentCate, 'children', [])
          }
          parentCate.children.push(category)
        }
      })
    }
  }
}

export default {
  state,
  getters,
  actions,
  mutations
}
