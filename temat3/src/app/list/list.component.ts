import { Component } from '@angular/core';
import {FormsModule} from "@angular/forms";
import {NgForOf} from "@angular/common";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  standalone: true,
  imports: [
    FormsModule,
    NgForOf
  ],
  styleUrls: ['./list.component.css']
})
export class ListComponent {
  items: string[] = []; // Lista elementów
  newItem: string = ''; // Pole dla nowego tekstu

  // Metoda dodająca nowy element do listy
  addItem(): void {
    if (this.newItem.trim()) {
      this.items.push(this.newItem.trim());
      this.newItem = ''; // Czyszczenie pola formularza
    }
  }

  // Metoda usuwająca element z listy wg indeksu
  removeItem(index: number): void {
    this.items.splice(index, 1);
  }
}
