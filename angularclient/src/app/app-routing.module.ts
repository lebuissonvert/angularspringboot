import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserListComponent } from './user-list/user-list.component';
import { UserListPrimengComponent } from './user-list-primeng/user-list-primeng.component';
import { UserListMaterialComponent } from './user-list-material/user-list-material.component';
import { UserListPrimengLazyComponent } from './user-list-primeng-lazy/user-list-primeng-lazy.component';
import { UserListFilteringPrimengLazyComponent } from './user-list-filtering-primeng-lazy/user-list-filtering-primeng-lazy.component';
import { UserAddFormComponent } from './user-add-form/user-add-form.component';
import { UserEditFormComponent } from './user-edit-form/user-edit-form.component';
import { DocumentListComponent } from './document-list/document-list.component';
import { DocumentEditComponent } from './document-edit/document-edit.component';
import { DocumentAddComponent } from './document-add/document-add.component';
import { DonutchartComponent } from './donutchart/donutchart.component';
import { MatUserAutocompleteComponent } from './mat-user-autocomplete/mat-user-autocomplete.component';
import { FullCalendarComponent } from './full-calendar/full-calendar.component';

const routes: Routes = [
  { path: 'users-material', component: UserListMaterialComponent },
  { path: 'users-primeng', component: UserListPrimengComponent },
  { path: 'users-primeng-lazy', component: UserListPrimengLazyComponent },
  { path: 'users-filtering-primeng-lazy', component: UserListFilteringPrimengLazyComponent },
  { path: 'users', component: UserListComponent },
  { path: 'adduser', component: UserAddFormComponent },
  { path: 'edituser/:id', component: UserEditFormComponent },
  { path: 'documents', component: DocumentListComponent },
  { path: 'editdocument/:id', component: DocumentEditComponent },
  { path: 'adddocument', component: DocumentAddComponent },
  { path: 'charts', component: DonutchartComponent },
  { path: 'mat-autocomplete-users', component: MatUserAutocompleteComponent },
  { path: 'full-calendar', component: FullCalendarComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
