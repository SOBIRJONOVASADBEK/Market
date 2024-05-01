import HelloWorld from "@/components/HelloWorld.vue";
import AppLogin from "@/components/AppLogin.vue";
import AppProduct from "@/components/AppProduct.vue";
export default [
    {path:'/',components:HelloWorld},
    {path:'/login',components:AppLogin},
    {path: '/product',components: AppProduct}
]