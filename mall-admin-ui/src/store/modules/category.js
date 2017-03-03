import Vue from 'vue'
import * as type from '../mutation-types'
import { createCategory, getCategoryList } from '../../api/category-api'

const state = {
  categoryList: []
}

const getters = {
  categoryList: state => state.categoryList
}

const actions = {
  addCategory: ({ commit }, category) => {
    commit(type.ADD_CATEGORY, {category})
  },
  getCategoryList: ({ commit }) => {
    getCategoryList().then(res => {
      let list = res.data
      commit(type.RECEIVE_CATEGORY_LIST, { list })
    })
  }
}

const mutations = {
  [type.RECEIVE_CATEGORY_LIST]: (state, { categoryList }) => {
    state.categoryList = categoryList
  },
  [type.ADD_CATEGORY]: (state, { category }) => {
    let asRoot = category.parentId === -1
    let parentCate = state.categoryList.find(cate => { return (cate.id === category.parentId) })

    if (asRoot || parentCate) {
      createCategory(category).then((res) => {
        console.log('createCategory res:', res)
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
