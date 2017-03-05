import Vue from 'vue'
import Vuex from 'vuex'
import category from './modules/category'
import auth from './modules/auth'

Vue.use(Vuex)

const store = new Vuex.Store({
  state: {

  },

  modules: {
    auth,
    category
  },

  actions: {

  },

  mutations: {

  },

  getters: {

  }
})

export default store
