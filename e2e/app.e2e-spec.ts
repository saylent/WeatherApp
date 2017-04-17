import { PollshareMarketPage } from './app.po';

describe('pollshare-market App', () => {
  let page: PollshareMarketPage;

  beforeEach(() => {
    page = new PollshareMarketPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
