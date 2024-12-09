import { Injectable } from '@angular/core';

export interface Person {
  firstName?: string;
  familyName?: string;
  age?: number;
  address: {
    city?: string;
    street?: string;
    postCode?: string;
  };
}

@Injectable({
  providedIn: 'root'
})
export class PersonService {
  private storageKey = 'persons'; // Klucz używany w localStorage

  constructor() {}

  // Wczytanie wszystkich danych z localStorage
  getAll(): Person[] {
    const data = localStorage.getItem(this.storageKey);
    return data ? JSON.parse(data) : [];
  }

  // Wczytanie wskazanego elementu z danych w localStorage
  get(index: number): Person | null {
    const persons = this.getAll();
    return persons[index] || null;
  }

  // Dodanie pojedynczego obiektu Person do localStorage
  add(person: Person): void {
    const persons = this.getAll();
    persons.push(person);
    this.save(persons);
  }

  // Usunięcie wskazanego elementu z danych w localStorage
  remove(index: number): void {
    const persons = this.getAll();
    if (index >= 0 && index < persons.length) {
      persons.splice(index, 1);
      this.save(persons);
    }
  }

  // Prywatna metoda do zapisywania danych w localStorage
  private save(persons: Person[]): void {
    localStorage.setItem(this.storageKey, JSON.stringify(persons));
  }
}
