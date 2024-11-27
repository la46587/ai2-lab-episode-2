import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class RandomService {
  constructor() {}

  getRandomNumber(max: number): number {
    return Math.floor(Math.random() * max) + 1; // Losowa liczba od 1 do max
  }
}
