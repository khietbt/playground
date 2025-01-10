class RecentCounter {
  queue: number[];
  constructor() {
    this.queue = []
  }

  ping(t: number): number {
    return this.queue.length;
  }
}

