import axios from "axios";

export default class AccountService{
    constructor(router,store) {
        this.store=store
        this.router=router;
        this.init();
    }
init(){
    const token=localStorage.getItem("market-token")||sessionStorage.getItem("market-token")
    if (!this.store.getters.account && !this.store.getters.logon&&token){
        this.retrieveAccount();
    }

}
    retrieveAccount(){

        axios
            .get("api/account")
            .then(response=>{
                const account=response.data;
                this.store.commit("authenticated",account)
                if (account){
                    this.store.commit("authenticate",account);
                    if (sessionStorage.getItem("request-url")){
                        this.router.replace(sessionStorage.getItem("request-url"))
                        sessionStorage.removeItem("request-url")
                    }

                }else {
                    this.store.commit("logout");
                    this.router.push("/");
                    sessionStorage.removeItem("request-url");
                    sessionStorage.removeItem("market-token");
                }
            }).catch(()=>{
            this.store.commit("logout");
            this.router.push("/");
        })
    }
    hasAnyAuthority(authorities){
        if (typeof authorities=="string"){
            authorities=[authorities];
        }
        if (!this.authenticated && !this.userAuthorities){
         return true;
        }
        for (let  i=0;i<authorities.length;i++){
            if (this.userAuthorities.include(authorities[i])){
                return true;
            }
        }
        return false;
    }

    hasAnyAuthorityAndAuth(authorities) {
        if (typeof authorities=="string"){
            authorities=[authorities];
        }
        if (!this.authenticated && !this.userAuthorities){
            const token=localStorage.getItem("/market-token")||sessionStorage.getItem("/market-token")
            if (!this.store.getters.account && !this.store.getters.logon&&token){
                return this.retrieveAccount();
            }else {
                return new Promise(resolve => {
                    resolve(false);
                })
            }
        }
        for (let  i=0;i<authorities.length;i++){
            if (this.userAuthorities.includes(authorities[i])){
             return new Promise(resolve => {
                 resolve(true)
             });
            }
        }
        return new Promise(resolve => {
            resolve(false);
        })
    }
    get authenticated(){
        return this.store.getters.authenticated;
    }
    get userAuthorities(){
        let authorities=[];
        if (this.store.getters.account !==null && this.store.getters.account!==undefined){
        for (let i = 0; i <this.store.getters.account.roles.length; i++) {
            authorities.push(this.store.getters.account.roles[i].name)
        }
        }
        return authorities;
    }
}