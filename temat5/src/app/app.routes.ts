import { Routes } from '@angular/router';
import { TasksComponent } from './tasks/tasks.component';
import { ArchiveComponent } from './archive/archive.component';
import { NotFoundComponent } from './not-found/not-found.component';

export const routes: Routes = [
  { path: '', redirectTo: '/tasks', pathMatch: 'full' },
  { path: 'tasks', component: TasksComponent },
  { path: 'archive', component: ArchiveComponent },
  { path: '**', component: NotFoundComponent },
];
