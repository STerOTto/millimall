import Vue from 'vue'
import Vuex from 'vuex'
import { createCategory } from './category-api'

Vue.use(Vuex)

const store = new Vuex.Store({
  state: {
    categoryList: [{
      id: 666,
      name: 'level 1'
    }]
  },

  actions: {
    addCategory: ({ commit }, category) => {
      commit('ADD_CATEGORY', {category})
    }
  },

  mutations: {
    ADD_CATEGORY: (state, { category }) => {
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
  },

  getters: {
    categoryList: state => state.categoryList
  }
})

export default store
