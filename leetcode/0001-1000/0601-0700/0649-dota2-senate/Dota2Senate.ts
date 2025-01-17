function predictPartyVictory(senate: string): string {
  const qr: number[] = [];
  const qd: number[] = [];

  for (let i = 0; i < senate.length; i++) {
    if (senate[i] === "R") {
      qr.push(i);
    } else {
      qd.push(i);
    }
  }

  while (qr.length > 0 && qd.length > 0) {
    const r = qr.shift();
    const d = qd.shift();

    if (r! < d!) {
      qr.push(r! + senate.length);
    } else {
      qd.push(d! + senate.length);
    }
  }

  return qr.length === 0 ? "Dire" : "Radiant";
};

// console.log(predictPartyVictory("RD"));
// console.log(predictPartyVictory("RDD"));
console.log(predictPartyVictory("RDRDRDRDR"));
