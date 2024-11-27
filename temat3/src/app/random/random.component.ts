import { Component, OnInit, Input } from '@angular/core';
import { RandomService } from '../random.service';
import {NgStyle} from "@angular/common";

@Component({
  selector: 'app-random',
  templateUrl: './random.component.html',
  standalone: true,
  imports: [
    NgStyle
  ],
  styleUrls: ['./random.component.css']
})
export class RandomComponent implements OnInit {
  @Input() max: number = 100; // Wartość domyślna dla maksymalnej liczby
  randomNumber!: number; // Wylosowana liczba
  comment!: string; // Komentarz

  constructor(private randomService: RandomService) {}

  ngOnInit(): void {
    this.generateRandomNumber(); // Generowanie liczby przy starcie
  }

  generateRandomNumber(): void {
    this.randomNumber = this.randomService.getRandomNumber(this.max);
    this.updateComment();
  }

  updateComment(): void {
    if (this.randomNumber <= 0.5 * this.max) {
      this.comment = 'Liczba jest mniejsza lub równa połowie maksymalnej wartości.';
    } else {
      this.comment = 'Liczba jest większa niż połowa maksymalnej wartości.';
    }
  }
}
