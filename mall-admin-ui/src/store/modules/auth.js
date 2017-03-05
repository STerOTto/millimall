import * as types from '../mutation-types'

const AUTH_KEY = 'MALL_ADMIN_AUTH'

const auth = {
  state: {
    authInfo: {}
  },

  getters: {
    authInfo: state => state.authInfo
  },

  mutations: {
    [types.LOGIN]: (state, {auth}) => {
      window.sessionStorage.setItem(AUTH_KEY, JSON.stringify(auth))
      state.authInfo = auth
      console.log('mutations - login', state.authInfo)
    },
    [types.LOGOUT]: (state) => {
      window.sessionStorage.removeItem(AUTH_KEY)
      state.authInfo = {}
    }
  }
}
export default auth
