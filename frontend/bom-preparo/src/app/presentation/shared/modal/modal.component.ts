import { Component, EventEmitter, Injectable, Input, OnInit, Output, TemplateRef, ViewChild } from "@angular/core";
import { NgbModal, NgbModalConfig, NgbModalRef } from "@ng-bootstrap/ng-bootstrap";
import { ModalConfig } from "./modal.config";

@Component({
  selector: 'app-modal',
  template: `
  <ng-template #modal let-confirm="close">
    <div class="modal-header">
      <h5 class="modal-title" *ngIf="modalConfig.error">
        Erro
      </h5>

      <h5 class="modal-title" *ngIf="modalConfig.alert">
        Alerta
      </h5>

      <h5 class="modal-title" *ngIf="modalConfig.success">
        Sucesso
      </h5>
    </div>

    <div class="modal-body">
      {{ modalConfig.message }}
    </div>

    <div class="modal-footer">
      <button type="button" class="btn btn-outline-primary" (click)="dismiss()" *ngIf="modalConfig.dismissButtonLabel !== undefined">
        {{ modalConfig.dismissButtonLabel }}
      </button>

      <button type="button" class="btn btn-outline-primary" (click)="close()" *ngIf="modalConfig.closeButtonLabel !== undefined">
        {{ modalConfig.closeButtonLabel }}
      </button>

      <button type="button" class="btn btn-outline-primary" (click)="confirm('Confirm click')" *ngIf="modalConfig.confirmButtonLabel !== undefined">
        {{ modalConfig.confirmButtonLabel }}
      </button>
    </div>
  </ng-template> `
})
@Injectable()
export class ModalComponent implements OnInit {

  @Input() public modalConfig!: ModalConfig;
  @ViewChild('modal') private modalContent!: TemplateRef<ModalComponent>;
  @Output() newConfirmationEvent = new EventEmitter<string>();

  private modalRef!: NgbModalRef;

  constructor(private modalService: NgbModal, private NgbModalConfig: NgbModalConfig) {
    this.NgbModalConfig.backdrop = 'static';
    this.NgbModalConfig.keyboard = false;
  }

  ngOnInit(): void { }

  open(): Promise<boolean> {
    return new Promise<boolean>(resolve => {
      this.modalRef = this.modalService.open(this.modalContent);
      this.modalRef.result.then((result) => {
        console.log('result: ', result);
        this.newConfirmationEvent.emit(result);
      });
    });
  }

  close() {
    this.modalRef.close();
  }

  dismiss() {
    this.modalRef.dismiss();
  }

}
