export interface ModalConfig {

  message?: any;

  dismissButtonLabel?: string;
  closeButtonLabel?: string;
  confirmButtonLabel?: string;
  confirmButtonAction?: string;

  error?(): boolean;
  alert?(): boolean;
  success?(): boolean;

}
