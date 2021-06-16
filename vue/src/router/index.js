import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import BookManage from '../views/BookManage'
import AddBook from '../views/AddBook'
import Index from '../views/Index'
import BookUpdate from '../views/BookUpdate'
import Register from '../views/Register'
import BookList from '../views/BookList'
import Book from '../views/Book'
import Login from '../views/Login';

Vue.use(VueRouter)

const routes = [
	  {
		  path: "/",
		  name: "图书管理",
		  component: Index,
		  show:true,
		  redirect: "/BookManage",
		  children:[
			  {
			  		  path:"/BookManage",
			  		  name:"查询图书",
			  		  component:BookManage
			  },
			  {
			  		  path:"/AddBook",
			  		  name:"添加图书",
			  		  component:AddBook
			  }
		  ]
	  },
	  {
		  path:'/update',
		  component:BookUpdate,
		  show:false
	  },
	 {
		path:'/login',
		 component:Login,
		 show:false
	 },
	 
	 {
	 		path:'/register',
	 		 component:Register,
	 		 show:false
	 },
	 
	 {
	 		path:'/booklist',
	 		 component:BookList,
	 		 show:false
	 },
	 
	 {
	 		path:'/book',
	 		 component:Book,
	 		 show:false
	 }
	  
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
