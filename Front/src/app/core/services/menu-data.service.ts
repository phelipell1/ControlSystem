import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { CustomMenuItem } from '../models/menu-item.model';

@Injectable({
    providedIn: 'root',
})
/**
 * menu data service
 */
export class MenuDataService {

    public toggleMenuBar: BehaviorSubject<any> = new BehaviorSubject<any>(null);

    getMenuList(): CustomMenuItem[] {
        return [
            {
                Label: 'Home', Icon: 'fa-home', RouterLink: '/main/dashboard', Childs: null, IsChildVisible: false
            },
            {
                Label: 'Cadastros', Icon: 'fa-cart-plus', RouterLink: null, Childs: [
                    { Label: 'Atividades', RouterLink: '/main/atividade', Childs: null, IsChildVisible: false },
                    { Label: 'Usuario', RouterLink: '/main/usuario', Childs: null, IsChildVisible: false }

                ], IsChildVisible: false
            }
        ];
    }
}
