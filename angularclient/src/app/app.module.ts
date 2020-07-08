import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { UserListComponent } from './user-list/user-list.component';
import { DocumentListComponent } from './document-list/document-list.component';
import { UserAddFormComponent } from './user-add-form/user-add-form.component';
import { UserEditFormComponent } from './user-edit-form/user-edit-form.component';
import { UserService } from './service/user.service';
import { DocumentService } from './service/document.service';
import { DocumentEditComponent } from './document-edit/document-edit.component';
import { DocumentAddComponent } from './document-add/document-add.component';
import { UserListPrimengComponent } from './user-list-primeng/user-list-primeng.component';
import { TableModule } from 'primeng/table';
import { MultiSelectModule } from 'primeng/multiselect';
import { SliderModule } from 'primeng/slider';
import { UserListPrimengLazyComponent } from './user-list-primeng-lazy/user-list-primeng-lazy.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { UserListFilteringPrimengLazyComponent } from './user-list-filtering-primeng-lazy/user-list-filtering-primeng-lazy.component'
import { FieldPipe } from './user-list-filtering-primeng-lazy/field.pipe';
import { DonutchartComponent } from './donutchart/donutchart.component';
import { ChartModule } from 'primeng/chart';
import { CardModule } from 'primeng/card';
import { ButtonModule } from 'primeng';

import { MatUserAutocompleteComponent } from './mat-user-autocomplete/mat-user-autocomplete.component';
import { MatSelectModule } from '@angular/material/select';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { ReactiveFormsModule } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { UserListMaterialComponent } from './user-list-material/user-list-material.component';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { MatTableModule } from '@angular/material/table';
import { FullCalendarComponent } from './full-calendar/full-calendar.component'
import { FullCalendarModule } from 'primeng/fullcalendar';
import { DialogModule } from 'primeng';
import {DropdownModule} from 'primeng/dropdown';

@NgModule({
  declarations: [
    AppComponent,
    UserListComponent,
    UserAddFormComponent,
    UserEditFormComponent,
    DocumentListComponent,
    DocumentEditComponent,
    DocumentAddComponent,
    UserListPrimengComponent,
    UserListPrimengLazyComponent,
    UserListFilteringPrimengLazyComponent,
    FieldPipe,
    DonutchartComponent,
    MatUserAutocompleteComponent,
    UserListMaterialComponent,
    FullCalendarComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    TableModule,
    SliderModule,
    MultiSelectModule,
    ChartModule,
    CardModule,
    ButtonModule,
    MatSelectModule,
    MatAutocompleteModule,
    MatInputModule,
    MatPaginatorModule,
    MatTableModule,
    MatSortModule,
    FullCalendarModule,
    DialogModule,
    DropdownModule
  ],
  providers: [
    UserService,
    DocumentService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
