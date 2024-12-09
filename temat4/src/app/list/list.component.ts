import { Component, OnInit } from '@angular/core';
import { PersonService, Person } from '../person.service';
import {RouterLink} from "@angular/router";
import {NgForOf} from "@angular/common";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  standalone: true,
  imports: [
    RouterLink,
    NgForOf
  ],
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  persons: Person[] = [];

  constructor(private personService: PersonService) {}

  ngOnInit(): void {
    this.loadPersons(); // Wczytaj osoby przy inicjalizacji
  }

  // Wczytanie wszystkich osób z serwisu
  private loadPersons(): void {
    this.persons = this.personService.getAll();
  }

  // Usunięcie osoby na podstawie indeksu
  removePerson(index: number): void {
    this.personService.remove(index); // Usuń osobę z serwisu
    this.loadPersons(); // Odśwież listę po usunięciu
  }
}
