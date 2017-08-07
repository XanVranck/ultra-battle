import { UltraBattleAngularPage } from './app.po';

describe('ultra-battle-angular App', () => {
  let page: UltraBattleAngularPage;

  beforeEach(() => {
    page = new UltraBattleAngularPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
