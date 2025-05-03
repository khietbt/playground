class ProductOfNumbers {
  constructor(private stack: number[]) {

  }

  add(num: number): void {
    this.stack.push(num);
  }

  getProduct(k: number): number {
    let product = 1;

    for (let i = this.stack.length - k; i < this.stack.length; i++) {
      product *= this.stack[i];
    }

    return product;
  }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * var obj = new ProductOfNumbers()
 * obj.add(num)
 * var param_2 = obj.getProduct(k)
 */
