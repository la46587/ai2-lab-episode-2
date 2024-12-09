import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { PersonService, Person } from '../person.service';
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-add-person',
  templateUrl: './add-person.component.html',
  standalone: true,
  imports: [
    FormsModule,
    FormsModule
  ],
  styleUrls: ['./add-person.component.css']
})
export class AddPersonComponent {
  // Obiekt reprezentujący nowe dane osobowe
  person: Person = {
    address: {}
  };

  constructor(private personService: PersonService, private router: Router) {}

  // Zapis danych i przekierowanie na stronę startową
  save(): void {
    this.personService.add(this.person); // Dodanie danych do serwisu
    this.router.navigate(['/']); // Przekierowanie na stronę główną
  }
}
