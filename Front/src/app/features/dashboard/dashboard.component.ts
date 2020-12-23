import { ConfirmationService, MessageService } from "primeng/api";
import { Component, OnInit } from "@angular/core";
import { TranslateService } from "@ngx-translate/core";
import { SelectItem } from "primeng";

@Component({
  selector: "app-dashboard",
  templateUrl: "dashboard.component.html",
  styleUrls: ["dashboard.component.css"],
})
export class DashboardComponent implements OnInit {
  //produtos: Produto[];

 // produto: Produto;

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

  /*findByValue(prod: string): string {
    let valor = null;
    for (let i = 0; i < this.produtos.length; i++) {
      if (this.produtos[i].descricao == prod) {
        valor = i;
        break;
      }
    }

    return valor;
    console.log(valor);
  }*/
}
