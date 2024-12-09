import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, RouterLink} from '@angular/router';
import { PersonService, Person } from '../person.service';
import {NgIf} from "@angular/common";

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  standalone: true,
  imports: [
    NgIf,
    RouterLink
  ],
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {
  person: Person | null = null; // Osoba do wyświetlenia

  constructor(private route: ActivatedRoute, private personService: PersonService) {}

  ngOnInit(): void {
    const index = +this.route.snapshot.paramMap.get('id')!; // Pobierz indeks z parametrów URL
    this.person = this.personService.get(index); // Pobierz dane osoby z serwisu
  }
}
