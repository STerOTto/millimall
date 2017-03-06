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
    [types.LOGIN]: (state, {authInfo}) => {
      window.sessionStorage.setItem(AUTH_KEY, JSON.stringify(authInfo))
      state.authInfo = authInfo
    },
    [types.LOGOUT]: (state) => {
      window.sessionStorage.removeItem(AUTH_KEY)
      state.authInfo = {}
    }
  }
}
export default auth
