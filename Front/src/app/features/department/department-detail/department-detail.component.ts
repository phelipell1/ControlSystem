import { Component, OnInit } from '@angular/core';
import { DepartmentDataService } from 'src/app/features/department/department-data.service';
import { RouteStateService } from 'src/app/core/services/route-state.service';

@Component({
  selector: 'app-department-detail',
  templateUrl: 'department-detail.component.html',
  styleUrls: ['department-detail.component.css']
})
export class DepartmentDetailComponent implements OnInit {


  constructor(
    private departmentService: DepartmentDataService,
    private routeStateService: RouteStateService) { }

  ngOnInit() {
  }

  back() {
    this.routeStateService.loadPrevious();
  }
}
