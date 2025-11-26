import { defineStore } from 'pinia'
import axios from 'axios'

export const useProductStore = defineStore('product', {
  state: () => ({
    products: []
  }),
  actions: {
    async fetchProducts() {
      try {
        const res = await axios.get('/api/products')
        console.log('Backend response:', res.data) 
        this.products = res.data
      } catch (err) {
        console.error('Failed to fetch products:', err)
      }
    }
  }
})
