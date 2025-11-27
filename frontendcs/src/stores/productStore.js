import { defineStore } from 'pinia'
import axios from 'axios'

export const useProductStore = defineStore('product', {
  state: () => ({
    products: [],
    searchQuery: ''
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
  },
  getters: {
    filteredProducts: (state) => {
      // if searchQuery is empty → return all products
      if (!state.searchQuery) return state.products

      // otherwise filter
      const q = state.searchQuery.toLowerCase()
      return state.products.filter(p =>
        p.name.toLowerCase().includes(q) ||
        String(p.price).includes(q)
      )
    }
  }

})
