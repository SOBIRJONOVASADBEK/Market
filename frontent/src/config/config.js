import {setAxiosInter} from "@/config/axios-interceptor";
// eslint-disable-next-line no-unused-vars
export function initVueApp(vue){
    setAxiosInter(()=>{
        console.log("Unauthorized!")
    })
}