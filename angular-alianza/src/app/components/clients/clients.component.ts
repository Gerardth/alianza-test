import { Component, OnInit } from '@angular/core';
import { NgxSpinnerService } from 'ngx-spinner';
import { ClientModel } from 'src/app/models/client.model';
import { ClientServicesService } from '../../services/client-services.service';

@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html',
  styleUrls: ['./clients.component.css']
})
export class ClientsComponent implements OnInit {

  public clientList: ClientModel[];

  public sharedKey = '';
  public name: string;
  public phone: number;
  public email: string;
  public startDate: Date;
  public endDate: Date;

  constructor(private clientService: ClientServicesService, private spinner: NgxSpinnerService) { }

  /**
   * Method to initialize component
   * @author grangel
   */
  public ngOnInit(): void {
    this.getClientList();
  }

  /**
   * Method to get a client info, given a shared key
   * @author grangel
   */
  public getClientInfo(): void {
    this.spinner.show();
    this.clientService.getClientInfo(this.sharedKey).subscribe(res => {
      this.clientList = res;
      this.spinner.hide();
    });
  }

  /**
   * Method to create a client
   * @author grangel
   */
  public createClient(): void {
    this.spinner.show();
    const client: ClientModel = {
      sharedKey: this.email.split('@')[0],
      businessId: this.name,
      email: this.email,
      phone: this.phone,
      startDate: this.startDate,
      endDate: this.endDate
    };

    this.clientService.createClient(client).subscribe(res => {
      this.spinner.hide();
      this.email = undefined;
      this.name = undefined;
      this.phone = undefined;
      this.startDate = undefined;
      this.endDate = undefined;
      this.getClientList();
    });
  }

  /**
   * Method to enable/disable button for client creation
   * @returns boolean
   * @author grangel
   */
  public validateFields(): boolean {
    return !!this.email && !!this.name && !!this.startDate && !!this.endDate && this.validatePhone();
  }

  /**
   * Method to get start date for date validation
   * @returns Date
   * @author grangel
   */
  public getStartDate(): Date {
    if (!!this.startDate) {
      return this.startDate;
    }
    return new Date();
  }

  /**
   * Method to get end date for date validation
   * @returns Date
   * @author grangel
   */
  public getEndDate(): Date {
    if (!!this.endDate) {
      return this.endDate;
    }
    return new Date();
  }

  /**
   * Method to get clients list
   * @author grangel
   */
  private getClientList(): void {
    this.spinner.show();
    this.clientService.getClientsList().subscribe(res => {
      this.clientList = res;
      this.spinner.hide();
    });
  }

  /**
   * Method to validate that phone is correct
   * @returns boolean
   * @author grangel
   */
  private validatePhone(): boolean {
    return !!this.phone && ((this.phone >= 3000000000 && this.phone <= 3029999999) || (this.phone >= 3100000000 && this.phone <= 3219999999)
      || (this.phone >= 3500000000 && this.phone <= 3509999999));
  }

}
