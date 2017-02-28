import Vue from 'vue'
import Vuex from 'vuex'

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
      console.log('action addCategory', category)
      commit('ADD_CATEGORY', {category})
    }
  },

  mutations: {
    ADD_CATEGORY: (state, { category }) => {
      console.log('mutations ADD_CATEGORY', category)
      if (category.parentId === -1) {
        state.categoryList.push(category)
      } else {
        let parentCate = state.categoryList.find(cate => { return (cate.id === category.parentId) })

        if (parentCate) {
          if (!parentCate.children) {
            parentCate.children = []
          }
          parentCate.children.push(category)
          // parentCate.children = parentCate.children.concat()
          console.log('find parentCate', parentCate)
          state.categoryList = state.categoryList.concat()
        }
      }
    }
  },

  getters: {
    categoryList: state => state.categoryList
  }
})

export default store
