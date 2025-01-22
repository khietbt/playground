function canVisitAllRooms(rooms: number[][]): boolean {
  if (rooms.length === 1) {
    return true;
  }

  const visited: Set<number> = new Set();

  visited.add(0);

  const queue: number[] = [0];

  while (queue.length > 0) {
    const room = queue.shift()!;
    const keys = rooms[room];

    for (const key of keys) {
      if (!visited.has(key)) {
        visited.add(key);
        queue.push(key);
      }
    }
  }

  return visited.size === rooms.length;
};

console.log(canVisitAllRooms([[1, 3], [3, 0, 1], [2], [0]]));
console.log(canVisitAllRooms([[1], [2], [3], []]));

