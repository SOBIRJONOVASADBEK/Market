import Vue from "vue"
import Vuex from 'vuex'
import VuexPersistence from "vuex-persist";
const vuexLocal=new VuexPersistence({
    storage:window.localStorage
})

Vue.use(Vuex)
export default new Vuex.Store({
    state:{
        logon:false,
        userIdEntity:null,
        authenticated:false
    },
    mutations: {
        authenticate(state){
            state.logon=true;
        },
        authenticated(state,identity){
            state.userIdEntity=identity;
            state.authenticated=true;
            state.logon=false;
        },
        logout(state){
            state.userIdEntity=null;
            state.authenticated=false;

        }
    },
    getters: {
        logon:state=>state.logon,
        account:state=>state.userIdEntity,
        authenticated : state => state.authenticated
    },
    plugins:[vuexLocal.plugin]
});

