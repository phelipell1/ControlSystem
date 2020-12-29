import { Component, OnInit } from "@angular/core";
import { SelectItem } from "primeng";

@Component({
  selector: "app-dashboard",
  templateUrl: "dashboard.component.html",
  styleUrls: ["dashboard.component.css"],
})
export class DashboardComponent implements OnInit {
  imagem: any;

  sortOptions: SelectItem[];

  sortOrder: number;

  sortField: string;
  produtosDialog: boolean;
  submitted: boolean;

  constructor(
  ) {}

  ngOnInit() {
  }

  hideDialog() {
    this.produtosDialog = false;
    this.submitted = false;
  }

}
